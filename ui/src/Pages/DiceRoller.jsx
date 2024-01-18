import React from "react";
import DieRoller from '../components/DiceRollComponents/DieRoller.jsx';
import NavbarHead from './NavbarHead.jsx'

const DiceRoller = () => {
	return (
            <>
		<div id="root">
		    {NavbarHead()}
            {DieRoller()}
            </div>
            </>
	);
}

export default DiceRoller;