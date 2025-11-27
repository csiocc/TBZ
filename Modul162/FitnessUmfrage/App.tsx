import React from 'react';
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
  PieChart,
  Pie,
  Cell,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  PolarRadiusAxis,
  Radar,
  Legend,
  AreaChart,
  Area,
} from 'recharts';
import { 
  Activity, 
  Dumbbell, 
  Calendar, 
  TrendingUp, 
  Heart, 
  Award, 
  Users, 
  Target 
} from 'lucide-react';

import Card from './components/Card';
import CustomTooltip from './components/CustomTooltip';
import { mockSurveyData } from './data';
import { COLORS, PIE_COLORS } from './constants';

const App: React.FC = () => {
  const data = mockSurveyData;

  return (
    <div className="min-h-screen pb-20">
      {/* Header / Hero Section */}
      <header className="bg-gradient-to-r from-slate-900 via-slate-800 to-slate-900 border-b border-slate-700 sticky top-0 z-50">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-6">
          <div className="flex flex-col md:flex-row justify-between items-center gap-4">
            <div>
              <h1 className="text-3xl font-extrabold text-white tracking-tight">
                <span className="text-transparent bg-clip-text bg-gradient-to-r from-emerald-400 to-blue-500">
                  Fitness Umfrage
                </span>{' '}
                Auswertung
              </h1>
              <p className="text-slate-400 mt-1 text-sm">
                Detaillierte Analyse der Trainingsgewohnheiten und Ziele
              </p>
            </div>
            <div className="flex items-center gap-4 bg-slate-800 px-4 py-2 rounded-lg border border-slate-700">
              <Users className="text-blue-400 w-5 h-5" />
              <div>
                <p className="text-xs text-slate-400 uppercase font-bold tracking-wider">Teilnehmer</p>
                <p className="text-xl font-bold text-white">{data.totalParticipants}</p>
              </div>
            </div>
          </div>
        </div>
      </header>

      <main className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8 space-y-8">
        
        {/* Intro Grid */}
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          
          {/* Q1: Hours per week - PIE */}
          <Card 
            title="Trainingsdauer" 
            subtitle="Durchschnittliche Stunden pro Woche"
            icon={<Activity className="w-5 h-5" />}
          >
            <ResponsiveContainer width="100%" height="100%">
              <PieChart>
                <Pie
                  data={data.hoursPerWeek}
                  cx="50%"
                  cy="50%"
                  innerRadius={60}
                  outerRadius={80}
                  paddingAngle={5}
                  dataKey="value"
                >
                  {data.hoursPerWeek.map((entry, index) => (
                    <Cell key={`cell-${index}`} fill={PIE_COLORS[index % PIE_COLORS.length]} />
                  ))}
                </Pie>
                <Tooltip content={<CustomTooltip />} />
                <Legend verticalAlign="bottom" height={36} iconType="circle" />
              </PieChart>
            </ResponsiveContainer>
          </Card>

          {/* Q3: Frequency - BAR */}
          <Card 
            title="Trainingshäufigkeit" 
            subtitle="Trainingseinheiten pro Woche"
            icon={<Calendar className="w-5 h-5" />}
          >
            <ResponsiveContainer width="100%" height="100%">
              <BarChart data={data.frequencyPerWeek} margin={{ top: 10, right: 10, left: -20, bottom: 0 }}>
                <CartesianGrid strokeDasharray="3 3" stroke="#334155" vertical={false} />
                <XAxis dataKey="name" stroke="#94a3b8" tick={{fontSize: 12}} />
                <YAxis stroke="#94a3b8" tick={{fontSize: 12}} />
                <Tooltip content={<CustomTooltip />} cursor={{fill: '#334155', opacity: 0.2}} />
                <Bar dataKey="value" fill={COLORS.secondary} radius={[4, 4, 0, 0]} barSize={30} />
              </BarChart>
            </ResponsiveContainer>
          </Card>

           {/* Q4: Fitness Level - AREA/BAR */}
           <Card 
            title="Fitnesslevel" 
            subtitle="Selbsteinschätzung (1-6)"
            icon={<TrendingUp className="w-5 h-5" />}
          >
             <ResponsiveContainer width="100%" height="100%">
              <AreaChart data={data.fitnessLevel} margin={{ top: 10, right: 10, left: -20, bottom: 0 }}>
                <defs>
                  <linearGradient id="colorLevel" x1="0" y1="0" x2="0" y2="1">
                    <stop offset="5%" stopColor={COLORS.primary} stopOpacity={0.8}/>
                    <stop offset="95%" stopColor={COLORS.primary} stopOpacity={0}/>
                  </linearGradient>
                </defs>
                <CartesianGrid strokeDasharray="3 3" stroke="#334155" vertical={false} />
                <XAxis dataKey="name" stroke="#94a3b8" tick={{fontSize: 10}} interval={0} />
                <YAxis stroke="#94a3b8" tick={{fontSize: 12}} />
                <Tooltip content={<CustomTooltip />} />
                <Area type="monotone" dataKey="value" stroke={COLORS.primary} fillOpacity={1} fill="url(#colorLevel)" />
              </AreaChart>
            </ResponsiveContainer>
          </Card>
        </div>

        {/* Big Chart Section */}
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
          
          {/* Q2: Bench Press - BAR (Horizontal or Vertical with many categories) */}
          <Card 
            title="Bankdrücken Rekord" 
            subtitle="Maximalkraft (1RM)"
            icon={<Dumbbell className="w-5 h-5" />}
            className="col-span-1"
          >
            <ResponsiveContainer width="100%" height="100%">
              <BarChart data={data.benchPressRecord} margin={{ top: 20, right: 30, left: 0, bottom: 5 }}>
                <CartesianGrid strokeDasharray="3 3" stroke="#334155" vertical={false} />
                <XAxis dataKey="name" stroke="#94a3b8" tick={{fontSize: 12}} />
                <YAxis stroke="#94a3b8" tick={{fontSize: 12}} />
                <Tooltip content={<CustomTooltip />} cursor={{fill: '#334155', opacity: 0.2}} />
                <Bar dataKey="value" fill={COLORS.purple} radius={[4, 4, 0, 0]}>
                   {data.benchPressRecord.map((entry, index) => (
                    <Cell key={`cell-${index}`} fill={index > 4 ? COLORS.accent : COLORS.purple} />
                  ))}
                </Bar>
              </BarChart>
            </ResponsiveContainer>
          </Card>

          {/* Q7: Goals - RADAR */}
          <Card 
            title="Trainingsziele" 
            subtitle="Fokus der Teilnehmer"
            icon={<Target className="w-5 h-5" />}
            className="col-span-1"
          >
             <ResponsiveContainer width="100%" height="100%">
              <RadarChart cx="50%" cy="50%" outerRadius="70%" data={data.trainingGoals}>
                <PolarGrid stroke="#475569" />
                <PolarAngleAxis dataKey="name" tick={{ fill: '#e2e8f0', fontSize: 11 }} />
                <PolarRadiusAxis angle={30} domain={[0, 'auto']} tick={false} axisLine={false} />
                <Radar
                  name="Stimmen"
                  dataKey="value"
                  stroke={COLORS.cyan}
                  strokeWidth={2}
                  fill={COLORS.cyan}
                  fillOpacity={0.4}
                />
                <Tooltip content={<CustomTooltip />} />
              </RadarChart>
            </ResponsiveContainer>
          </Card>
        </div>

        {/* Lower Grid */}
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
          
          {/* Q5: Favorite Exercise - LIST/BAR */}
           <Card 
            title="Lieblingsübung" 
            subtitle="Top Favoriten"
            icon={<Heart className="w-5 h-5" />}
            className="md:col-span-2"
          >
             <ResponsiveContainer width="100%" height="100%">
              <BarChart 
                layout="vertical" 
                data={data.favoriteExercise} 
                margin={{ top: 5, right: 30, left: 40, bottom: 5 }}
              >
                <CartesianGrid strokeDasharray="3 3" stroke="#334155" horizontal={false} />
                <XAxis type="number" stroke="#94a3b8" hide />
                <YAxis dataKey="name" type="category" width={100} stroke="#94a3b8" tick={{fontSize: 12}} />
                <Tooltip content={<CustomTooltip />} cursor={{fill: '#334155', opacity: 0.2}} />
                <Bar dataKey="value" fill={COLORS.pink} radius={[0, 4, 4, 0]} barSize={20} />
              </BarChart>
            </ResponsiveContainer>
          </Card>

          {/* Q8: Primary Reason - DONUT */}
          <Card 
            title="Motivation" 
            subtitle="Primärer Grund für Sport"
            icon={<Award className="w-5 h-5" />}
          >
            <ResponsiveContainer width="100%" height="100%">
              <PieChart>
                <Pie
                  data={data.primaryReason}
                  cx="50%"
                  cy="50%"
                  innerRadius={50}
                  outerRadius={70}
                  paddingAngle={5}
                  dataKey="value"
                >
                  {data.primaryReason.map((entry, index) => (
                    <Cell key={`cell-${index}`} fill={PIE_COLORS[index % PIE_COLORS.length]} />
                  ))}
                </Pie>
                <Tooltip content={<CustomTooltip />} />
                <Legend verticalAlign="bottom" height={36} iconType="circle" />
              </PieChart>
            </ResponsiveContainer>
          </Card>
        </div>

        {/* Q6: Years Training - Simple Stats Row */}
        <div className="bg-slate-800/50 backdrop-blur-sm border border-slate-700 rounded-xl p-6 shadow-xl">
           <h3 className="text-xl font-bold text-white flex items-center gap-2 mb-4">
            <Activity className="text-emerald-400 w-5 h-5" />
            Trainingserfahrung (Jahre)
          </h3>
          <div className="grid grid-cols-2 md:grid-cols-6 gap-4">
            {data.yearsTraining.map((item, idx) => (
              <div key={idx} className="bg-slate-900/50 rounded-lg p-3 text-center border border-slate-800">
                <p className="text-2xl font-bold text-emerald-400">{item.value}</p>
                <p className="text-xs text-slate-400 font-medium uppercase mt-1">{item.name}</p>
              </div>
            ))}
          </div>
        </div>

      </main>
    </div>
  );
};

export default App;
