import React from 'react';
import { Link } from 'react-router-dom';
import Navbar from './components/Navbar';
import Banner from './components/Banner';
import Post from './components/Post';

export default function Blog() {
// Dummy data for blog posts
const postData = [
{
"title": "Dungeons and Dragons How-To Guide",
"description": "Embark on your Dungeons and Dragons journey with our comprehensive how-to guide. Learn the basics, from creating characters to mastering gameplay mechanics. Whether you're a beginner or a seasoned adventurer, this guide will enhance your D&D experience.",
"category": "Gaming",
"imageUrl": "https://www.wikihow.com/images/thumb/1/13/Play-Dungeons-and-Dragons-Step-8-Version-3.jpg/aid29731-v4-728px-Play-Dungeons-and-Dragons-Step-8-Version-3.jpg",
"date": "01/14/2022",
"id": 1
},
{
"title": "Unleashing Characters in Dungeons and Dragons",
"description": "Dive deep into the art of character creation in Dungeons and Dragons. Discover tips for developing unique personalities, backstories, and abilities for your characters. Whether you prefer spellcasting wizards or mighty warriors, unleash the full potential of your D&D heroes.",
"category": "Gaming",
"imageUrl": "https://www.wikihow.com/images/thumb/e/e9/Play-Dungeons-and-Dragons-Step-2-Version-3.jpg/aid29731-v4-728px-Play-Dungeons-and-Dragons-Step-2-Version-3.jpg", // Replace with an actual image URL
"date": "01/15/2022",
"id": 2
},
{
"title": "News",
"description": "Dive deep into the art of character creation in Dungeons and Dragons. Discover tips for developing unique personalities, backstories, and abilities for your characters. Whether you prefer spellcasting wizards or mighty warriors, unleash the full potential of your D&D heroes.",
"category": "News",
"imageUrl": "https://www.wikihow.com/images/thumb/3/31/Play-Dungeons-and-Dragons-Step-14-Version-3.jpg/aid29731-v4-728px-Play-Dungeons-and-Dragons-Step-14-Version-3.jpg",
"date": "01/15/2022",
"id": 3
},

];

return (
<div>
    <Navbar />
    <Banner />
    <div className="grid grid-cols-3 gap-4 p-8">
    {postData.map((post) => (
        <Link key={post.id} to={`/blog/${post.id}`}>
        <Post content={post} />
        </Link>
    ))}
    </div>
</div>
);
}