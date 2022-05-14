import { Routes, Route } from 'react-router-dom';
import { Layout } from './components/Layout';
import { TeamDetails } from './components/TeamDetails';
import { Tournament } from './components/Tournament';
import { Tournaments } from './pages/Tournaments';
import { Home } from './pages/Home';
import { Admin } from './pages/Admin';

export function App() {
	return (
		<div className='App w-screen h-screen'>
			<Routes>
				<Route path='/' element={<Layout />}>
					<Route path='/admin' element={<Admin />}/>
					<Route path='/' element={<Home />} />
					<Route path='/tournaments' element={<Tournaments />} />
					<Route path='/tournament'>
						<Route path=':id' element={<Tournament />} />
					</Route>
					<Route path='/team'>
						<Route path=':id' element={<TeamDetails />} />
					</Route>
				</Route>
			</Routes>
		</div>
	);
}
