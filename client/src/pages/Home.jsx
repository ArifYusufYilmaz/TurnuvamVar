import { useEffect, useState } from 'react';
import axios from '../api/axios';
import { Tournaments } from '../components/Tournaments';

export const Home = () => {
	const [tournaments, setTournaments] = useState([]);
	useEffect(() => {
		const fetchTourn = async () => {
			try {
				const tournamentsData = await axios.get('/tournaments/get/list');

				setTournaments(tournamentsData.data.data);
			} catch (error) {
				console.log(error);
			}
		};
		fetchTourn()
		
	}, []);

	return (
		<div className='p-10 flex flex-wrap'>
			<Tournaments tournaments={tournaments} />
		</div>
	);
};
