import React from 'react';

function Navbar() {
	return (
		<div className='navbar bg-base-100 border-b-2 p-4'>
			<div className='flex-1'>
				<a className='btn btn-ghost normal-case text-xl ' href='/'>
					TURNUVAMVAR
				</a>
			</div>
			<div className='flex-none'>
				<ul className='menu menu-horizontal p-0'>
					<li>
						<a href='/'>Ana Sayfa</a>
					</li>
					<li>
						<a href='/'>Hakkımızda</a>
					</li>
					<li>
						<a href='/'>İletişim</a>
					</li>
				</ul>
			</div>
		</div>
	);
}

export default Navbar;
