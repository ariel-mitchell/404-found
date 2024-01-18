import React from "react";
import CreateCharacterForm from "../components/CharacterComponents/CreateCharacterForm.jsx";
import NavbarHead from './NavbarHead.jsx'

const CharacterCreator = () => {
	return (
            <>
		<div id="root">
		    {NavbarHead()}
            {CreateCharacterForm()}
            </div>
            </>
	);
}

export default CharacterCreator;