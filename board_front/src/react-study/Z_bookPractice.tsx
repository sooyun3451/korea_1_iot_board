import axios from 'axios';
import React, { useEffect, useState } from 'react'

const DOMAIN = "http://localhost:8080";
const MENU_API = "api/v1/books";

interface GetBoooks {
  id: number;
  writer: string;
  title: string;
  content: string;
  category: Category;
}

type Category = "NOTICE" | "FREE" | "QNA" | "EVENT";

export default function Z_bookPractice() {
  const [book, setBook] = useState<GetBoooks>({
    id: 0,
    writer: '',
    title: '',
    content: '',
    category: 'NOTICE'
  });

  const [results, setResulte] = useState<GetBoooks[]>([]);
  const {id, writer, title, content, category} = book;

  const handleGetBooks = async () => {
    try {
      const response = await axios.get(`${DOMAIN}/${MENU_API}`);
      const data = response.data;
      setResulte(data);
    } catch(error) {
      console.error(error);
    } 
  }

  useEffect(() => {
    handleGetBooks();
  }, []);

  return (
    <div>
      <ul>
        {results.map((result, index) => (
          <li key={index}>{result.title}</li>
        ))}
      </ul>
    </div>
  )
}
