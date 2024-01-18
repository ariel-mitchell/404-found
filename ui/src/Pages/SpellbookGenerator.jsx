import React from "react";
import SpellbookGeneration from '../components/SpellBookComponents/SpellbookGeneration';
import NavbarHead from './NavbarHead.jsx'

const SpellbookGenerator = () => {
	return (
            <>
		<div id="root">
		    {NavbarHead()}
            {SpellbookGeneration()}
            </div>
            </>
	);
}

export default SpellbookGenerator;