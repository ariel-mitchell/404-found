// BlogList.jsx
import React from 'react';
import { ListGroup } from 'react-bootstrap';
import BlogItem from './BlogItem';

// BlogList component to display a list of blog posts
const BlogList = ({ posts, onDelete, onSelect }) => (
<ListGroup>
{/* Map through each blog post and render BlogItem component */}
{posts.map((item) => (
    <BlogItem key={item.id} item={item} onDelete={onDelete} onSelect={onSelect} />
))}
</ListGroup>
);

export default BlogList;