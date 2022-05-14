import React from 'react';
import { Card } from './Card';

export const Tournament = () => {
	const parameter = {
		baslik: 'Takim1',
		id: 0,
	};
	return (
		<div className='p-20'>
			<Card parameter={parameter} />
		</div>
	);
};
