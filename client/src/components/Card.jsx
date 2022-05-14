import { useNavigate } from 'react-router-dom';

export const Card = ({ parameter }) => {
	const navigate = useNavigate();

	const handleButtonClick = () => {
		if (parameter?.description) {
			navigate(`/tournament/${parameter.id}`);
		} else {
			navigate(`/team/${parameter.id}`);
		}
	};

	return (
		<div className='card bg-base-100 shadow-xl w-96'>
			<figure>
				<img
					src='https://api.lorem.space/image/shoes?w=400&h=225'
					alt='Shoes'
				/>
			</figure>
			<div className='card-body'>
				<h2 className='card-title'>{parameter?.name}</h2>
				<p>{parameter?.description ? parameter?.description : ''}</p>
				<div className='card-actions justify-end'>
					<button className='btn btn-primary' onClick={handleButtonClick}>
						{parameter?.description ? 'Detay' : 'Takim Detayi'}
					</button>
				</div>
			</div>
		</div>
	);
};
