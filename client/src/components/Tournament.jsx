import { useEffect, useState } from 'react';
import axios from '../api/axios'
import { Card } from './Card';

export const Tournament = () => {
	const [teams, setTeams] = useState([]);
	useEffect(() => {
		const fetchTeams = async () => {
			try {
				const teamsData = await axios.get('/teams/get/list');

				setTeams(teamsData.data.data);
			} catch (error) {
				console.log(error);
			}
		};
		fetchTeams()
		
	}, []);
	console.log(teams)
	return (
		<div className='p-10 flex flex-wrap gap-5 justify-between items-center'>
			{teams?.map(team => {
				let info = {
					id: team?.id,
					name: team?.teamName,
				};
				return <Card parameter={info} />;
			})}
		</div>
	);
};
