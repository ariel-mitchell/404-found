// components/Result.jsx
import React from 'react';

const Result = ({ outcomes }) => {
console.log('outcomes:', outcomes);

return (
<div>
    {/* Check if outcomes is defined and has length */}
    {outcomes?.length > 0 && (
    <div>
        <p>Results of the rolls:</p>
        {/* Display each outcome in an ordered list */}
        <ul>
        {outcomes.map((outcome, index) => (
            <li key={index}>Roll {index + 1}: <strong>{outcome}</strong></li>
        ))}
        </ul>
    </div>
    )}
</div>
);
};

export default Result;
