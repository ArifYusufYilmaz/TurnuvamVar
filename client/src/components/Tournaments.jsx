import { Card } from './Card';

export function Tournaments({ tournaments }) {
	console.log(tournaments)
	return (
		<div className='p-10'>
			{tournaments?.map(tournament => {
				let info = {
					id: tournament?.id,
					name: tournament?.tournamentName,
					description: tournament?.description,
				};
				return <Card parameter={info} />;
			})}
		</div>
	);
}
