import React from 'react';

function NextGames() {
	return (
		<div className='content-center'>
			<div>
				<p className='flex justify-center mt-5'>OYNANACAK MACLAR</p>
			</div>
			<div className='flex justify-center flex-col w-full lg:flex-row mt-2 border-2 border-rose-600'>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 1
				</div>
				<div className='divider lg:divider-horizontal'>VS</div>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 2
				</div>
			</div>
			<div className='flex flex-col w-full lg:flex-row mt-2'>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 1
				</div>
				<div className='divider lg:divider-horizontal'>VS</div>
				<div className='grid flex-grow h-16 card bg-base-300 rounded-box place-items-center'>
					TAKIM 2
				</div>
			</div>
		</div>
	);
}

export default NextGames;
