import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState([]);

  //manage any side effects from api

  useEffect(() => {
    (async () => await load())();
  }, []);

  return( 
    //api data pulled in html format
    <div></div>
  );
}

export default App
