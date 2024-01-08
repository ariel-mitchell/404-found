import React from "react";

function SpellCard({ spell }) {
    return (
        <li className="spell-card">
            <hgroup>
                <h4>{spell.name}</h4>
                <small>
                    {spell.level > 0 && `Level ${spell.level} `}
                    {spell.school.name}
                    {spell.level === 0 && 'cantrip'}
                </small>
            </hgroup>
            <div className="stats">
                <p>
                    <strong> Casting TIme: </strong> {spell.casting_time}
                </p>
                <p>
                    <strong>Range: </strong> {spell.range}
                </p>
                <p>
                    <strong>Components: </strong> {spell.components.join(', ')}
                </p>
                <p>
                    <strong>Duration: </strong>
                </p>
            </div>
        </li>  
    );
}

export default SpellCard;