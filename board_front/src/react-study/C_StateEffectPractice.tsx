import axios from 'axios';
import React, { useEffect, useState } from 'react'

const DOMAIN = "http://localhost:8080";
const MENU_API = "api/v1/menus";

interface GetMenuCategoryResponseDto {
  name: string;
  description: String;
  price: number;
  isAvailable: boolean;
  category: string;
  size: string;
}

type Category = 'Food' | 'Drink' | 'Dessert'; 

export default function C_StateEffectPractice() {
  const [category, setCategory] = useState<string>('');
  const [results, setResults] = useState<GetMenuCategoryResponseDto[]>([]);
  const ButtonCategory = (e: React.MouseEvent<HTMLButtonElement>) => {
    const selectCategory = e.currentTarget.value as Category;
    setCategory(selectCategory);
  }

  const fetchCategory = async (category: string) => {
    if(category.trim()) {
      try {
        const response = await axios.get(`${DOMAIN}/${MENU_API}/search/category`,
          {params: {category}}
        );
        const data = response.data.data;
        setResults(data);
      }catch(error) {
        console.error("Error Fetch Category: ", error);
      }
    }
  }

  useEffect(() => {
    fetchCategory(category);
  },[category])

  return (
    <div>
      <button value='Food' onClick={ButtonCategory}>Food</button>
      <button value='Drink' onClick={ButtonCategory}>Drink</button>
      <button value='Dessert' onClick={ButtonCategory}>Dessert</button>
      <ul>
        {results.map((result, index) => (
          <li key={index}>{result.name}</li>
        ))}
      </ul>
    </div>
  )
}
