import { Card } from './Card';

export function Tournaments({ tournaments }) {
	
	return (
		<div className='p-10 flex flex-wrap gap-5 justify-between items-center'>
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
