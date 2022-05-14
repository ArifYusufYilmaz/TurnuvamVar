import React from 'react';
import NextGames from './NextGames';
import PlayedGames from './PlayedGames';
import TeamPlayers from './TeamPlayers';

export function TeamDetails() {
	return (
		<div className='w-full h-full flex flex-col gap-8 py-5 px-10'>
			<div className='w-full flex gap-4 '>
				<div className='flex gap-2 border w-4/12 border-red-500'>
					<img src='' alt='Takim logosu' />
					<div className='flex flex-col'>
						<p>TAKIM ISMI</p>
						<p>BILGI</p>
					</div>
				</div>
				<TeamPlayers />
			</div>
			<NextGames />
			<PlayedGames />
		</div>
	);
}
