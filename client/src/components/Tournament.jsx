import { useEffect, useState } from 'react';
import axios from '../api/axios'
import { useParams } from 'react-router-dom';
import { Card } from './Card';

export const Tournament = () => {
	const [teams, setTeams] = useState([]);
	const params = useParams()
	console.log(params)
	const paramId = params.id
	useEffect(() => {
		const fetchTeams = async () => {
			try {
				const teamsData = await axios.get(`tournaments/get/${parseInt(paramId)}`);

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
