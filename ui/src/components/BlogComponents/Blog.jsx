// src/components/BlogComponents/Blog.jsx
import React from 'react';
import Banner from './Banner';
import Post from './Post';

// Blog component displaying the banner and blog posts
const Blog = () => {
    // Hardcoded blog post data
    const postData = [
        {
            department: "App Usage",
            title: "Mastering the DnD Character Creator App",
            author: "C.C. ",
            designation: "Mythologist - Level 20",
            info: "Unlock the full potential of the DnD Character Creator App with expert tips. Learn how to efficiently create and manage your characters for immersive Dungeons and Dragons adventures.",
        },
        {
            department: "D&D News",
            title: "Latest Adventures",
            author: "T.W. ",
            designation: "Loremaster - Level 20",
            info: "Stay updated with the latest news and adventures unfolding. Get exclusive insights into the world of Dungeons and Dragons.",
            },
            {
            department: "D&D Tips",
            title: "Enhancing Role-Playing Experience",
            author: "J.W. ",
            designation: "Spellcaster - Level 20",
            info: "Improve your Dungeons and Dragons role-playing experience with expert tips. Dive into the world of immersive storytelling and character development.",
            },
            {
            department: "D&D How-Tos",
            title: "Mastering Dungeon Creation",
            author: "J.V. ",
            designation: "Guildmaster - Level 15",
            info: "Learn the art of creating captivating dungeons in your Dungeons and Dragons campaigns. Tips on mastering dungeon design.",
            }
        ];

    return (
        <div>
            <Banner />
            <div className="container mt-4">
                <div className="row row-cols-1 row-cols-md-4 g-4">
                    {/* Mapping through blog post data and rendering Post component */}
                    {postData.map((entry, index) => (
                        <Post key={index} content={entry} />
                    ))}
                </div>
            </div>
        </div>
    );
};

export default Blog;