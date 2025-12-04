

class Database
  attr_reader :leistungsbeurteilungen, :module_liste
  def initialize
    @lernende = []
    @leistungsbeurteilungen = []
    @module_liste = []
  end

  def self.instance
    @db ||= new
  end

  private_class_method :new

  def lernende_id
    @lernende.size + 1
  end

  def leistungs_id
    @leistungsbeurteilungen.size + 1
  end

  def modul_id
    @module_liste.size + 1
  end

  def email_taken?(email)
    @lernende.any? { |lernender| lernender.email == email }
  end

  def module_name_taken?(name)
    @module_liste.any? { |modul| modul.name == name }
  end

  def lernende
    @lernende
  end

  def add_lernender(lernender)
    @lernende << lernender
  end

  def add_modul(modul)
    @module_liste << modul
  end

  def add_lb(lb)
    @leistungsbeurteilungen << lb
  end

  def list_lernende
    @lernende.each do |lernender|
      puts "Lernende-ID: #{lernender.id}, Name: #{lernender.vorname} #{lernender.nachname}, Klasse: #{lernender.klasse}, E-Mail: #{lernender.email}"
    end
  end

  def to_json
    require 'json'
    @lernende.map(&:to_h).to_json
  end

end

class Lernender

  attr_reader :id, :vorname, :nachname, :klasse, :email
  attr_accessor :lbs, :module_liste
  @@db = Database.instance
  def initialize(vorname, nachname, klasse, email)
    @db = Database.instance
    raise "E-Mail #{email} ist bereits vergeben." if @db.email_taken?(email)

    @id = @db.lernende_id
    @vorname = vorname
    @nachname = nachname
    @klasse = klasse
    @email = email
    @lbs = []
    @module_liste = []

    p "Neuer Lernender erstellt: #{@vorname} #{@nachname}, Klasse: #{@klasse}, E-Mail: #{@email}" if DEBUG
    @db.add_lernender(self)

  end

  def add_lb(note = nil, modul = nil)
    lb = LeistungsBeurteilung.new(note, self, modul)
    lb
  end

  def add_modul(modul)
    return if @module_liste.include?(modul)
    @module_liste << modul
    modul.add_lernender(self)
  end

  def list_lbs
    @lbs.each do |lb|
      modul_name = lb.modul ? lb.modul.name : "kein Modul"
      p "Modul #{modul_name} Leistungsbeurteilung-ID: #{lb.id}, Note: #{lb.note}, Lernender: #{lb.lernender&.vorname} #{lb.lernender&.nachname}" if DEBUG
    end
    return nil
  end

  def fullname
    return "#{self.vorname} #{self.nachname}"
  end

  def to_h
    {
      id: id,
      vorname: vorname,
      nachname: nachname,
      klasse: klasse,
      email: email
    }
  end

  def self.all
    @@db.lernende
  end

  def self.where(**kwargs)
    results = all.select do |record|
      kwargs.all? do |key, value|
        next false unless record.respond_to?(key)

        if key == :module_liste && value.is_a?(String)
          record.module_liste.any? { |mod| mod.name.downcase == value.downcase }
        else
          record_value = record.send(key)

          if record_value.is_a?(String) && value.is_a?(String)
            record_value.downcase == value.downcase
          else
            record_value == value
          end
        end
      end
    end

    return nil if results.empty?
    return results.first if results.size == 1
    results
  end

end

class LeistungsBeurteilung
  attr_accessor :id, :note, :lernender, :modul
  @@db = Database.instance
  def initialize(note = nil, lernender = nil, modul = nil)
    @db = Database.instance
    @note = note
    @lernender = lernender
    @modul = modul
    @id = @db.leistungs_id

    @db.add_lb(self)
    @modul.add_lb(self) if @modul
    @modul.add_lernender(@lernender) if @modul && @lernender
    @lernender.add_modul(@modul) if @lernender && @modul
    @lernender.lbs << self if @lernender && !@lernender.lbs.include?(self)

    p "Neue Leistungsbeurteilung erstellt: ID #{@id}, Note: #{@note} Lernenender: #{@lernender&.vorname} #{@lernender&.nachname}, Modul: #{@modul&.name}" if DEBUG
  end

  def self.note
    @note
  end

  def self.get_average(modul = nil)
    sum = 0
    average = 0
    amount = 0
    if modul
      p "Average for #{modul.name}"
      @@db.leistungsbeurteilungen.each do |lb|
        if lb.modul == modul
          sum += lb.note
          amount += 1
        end
      end
    else
      p "Average over all Modules"
      @@db.leistungsbeurteilungen.each do |lb|
        sum += lb.note
        amount += 1
      end
      
    end
    average = (sum / amount)
    average
  end
  
end

class SchulModul

  attr_reader :id, :name, :lernende, :leistungsbeurteilungen

  def initialize(name)
    @db = Database.instance
    raise "Modul-Name #{name} ist bereits vergeben." if @db.module_name_taken?(name)
    @name = name
    @id = @db.modul_id
    @lernende = []
    @leistungsbeurteilungen = []
    @db.add_modul(self)
    p "Neues Modul erstellt: #{@name} (ID #{@id})" if DEBUG
  end

  def add_lernender(lernender)
    return if lernender.nil?
    return if @lernende.include?(lernender)
    @lernende << lernender
  end

  def add_lb(lb)
    return if lb.nil?
    @leistungsbeurteilungen << lb unless @leistungsbeurteilungen.include?(lb)
  end

  def list_lernende
    @lernende.each do |lernender|
      p "Modul #{@name} hat Lernender: #{lernender.vorname} #{lernender.nachname}"
    end
  end

  def get_lernende_amount
    @lernende.length
  end

  def list_lbs(lernender)
    @leistungsbeurteilungen.each do |lb|
      if lb.lernender == lernender
        p "Modul #{@name} Leistungsbeurteilung-ID: #{lb.id}, Note: #{lb.note}, Lernender: #{lb.lernender&.vorname} #{lb.lernender&.nachname}"
      end
    end
  end
end

DEBUG = false

db = Database.instance

## DB Seeding data ##
lernende = []
lernende << Lernender.new("Max", "Mustermann", "2A", "max@max.ch")
lernende << Lernender.new("Erika", "Musterfrau", "2B", "erika@erika.ch")
lernende << Lernender.new("Peter", "Schmidt", "3A", "peter@peter.ch")
lernende << Lernender.new("Laura", "Keller", "3B", "laura@laura.ch")
lernende << Lernender.new("Sandro", "Frei", "4A", "sandro@sandro.ch")
lernende << Lernender.new("Nina", "Weber", "4B", "nina@nina.ch")
lernende << Lernender.new("Jonas", "Baumann", "5A", "jonas@jonas.ch")
lernende << Lernender.new("Lea", "Schmid", "5B", "lea@lea.ch")

mathe = SchulModul.new("Mathe")
bio = SchulModul.new("Bio")
informatik = SchulModul.new("Informatik")
module_liste = [mathe, bio, informatik]

lernende.each do |lernender|
  module_liste.each do |modul|
    lernender.add_modul(modul)
  end
end

noten = [4, 4.5, 5, 5.5, 6]
module_liste.each do |modul|
  lernende.each do |lernender|
    5.times do
      note = noten.sample
      lernender.add_lb(note, modul)
    end
  end
end

######
#
#

# Ausgabe-Beispiele

# db.module_liste[0].list_lbs(lernende.first)  ///  db.lernende[0].module_liste[0].list_lbs(lernende.first)
# 
# "Modul Mathe Leistungsbeurteilung-ID: 1, Note: 4, Lernender: Max Mustermann"
# "Modul Mathe Leistungsbeurteilung-ID: 2, Note: 4.5, Lernender: Max Mustermann"
# "Modul Mathe Leistungsbeurteilung-ID: 3, Note: 5, Lernender: Max Mustermann"
# "Modul Mathe Leistungsbeurteilung-ID: 4, Note: 5.5, Lernender: Max Mustermann"
# "Modul Mathe Leistungsbeurteilung-ID: 5, Note: 6, Lernender: Max Mustermann"




# db.lernende[0].module_liste[0].list_lbs(lernende.first)
# "Modul Mathe Leistungsbeurteilung-ID: 1, Note: 5, Lernender: Max Mustermann"
# "Modul Mathe Leistungsbeurteilung-ID: 3, Note: 6, Lernender: Max Mustermann"

# p db.leistungsbeurteilungen[0].lernender.fullname
#  Max Mustermann

# p db.lernende.first.fullname
# "Max Mustermann"

# p LeistungsBeurteilung.get_average(db.module_liste[1])   #// Noten Durchschnitt für das Fach Bio
# "Average for Bio"
# 5.0
# 

# p LeistungsBeurteilung.get_average  #// Noten durchschnitt über alle Module
# "Average over all Modules"
# 5.095833333333333
# 

# p db.module_liste[0].get_lernende_amount   #// Wieviele Lernende hat das entsprechende Modul
# 8



## Nachträglich implementiert Querry helper
#
# -macht aufrufe einfacher
#z.b
# p Lernender.where(vorname: "MaX").fullname  // p Lernender.where(email: "max@max.ch").fullname  // p Lernender.where(nachname: "mUsteRmAnn").fullname

# puts Lernender.where(module_liste: "Mathe")  // return array aus allen lernenden mit dem Modul Mathe
#  
#<Lernender:0x00007f495e795820>
#<Lernender:0x00007f495e7957d0>
#<Lernender:0x00007f495e795780>
#<Lernender:0x00007f495e795730>
#<Lernender:0x00007f495e795640>
#<Lernender:0x00007f495e7955f0>
#<Lernender:0x00007f495e795550>
#<Lernender:0x00007f495e795500>