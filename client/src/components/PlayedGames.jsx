import React from 'react';

function PlayedGames() {
	return (
		<>
			<div>
				<p className='flex justify-center mt-5'>GECMIS MACLAR</p>
			</div>
			<div className='flex flex-col w-full lg:flex-row mt-2'>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 1
				</div>
				<div className='divider lg:divider-horizontal'>1-2</div>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 2
				</div>
			</div>
			<div className='flex flex-col w-full lg:flex-row mt-2'>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 1
				</div>
				<div className='divider lg:divider-horizontal'>2-0</div>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 2
				</div>
			</div>
		</>
	);
}

export default PlayedGames;
