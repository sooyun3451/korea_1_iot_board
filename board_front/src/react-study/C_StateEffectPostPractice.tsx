import axios from "axios";
import React, { useEffect, useState } from "react";

const DOMAIN = "http://localhost:8080";
const MENU_API = "api/v1/menus";

interface PostMenuRequestDto {
  name: string;
  description: String;
  price: number;
  isAvailable: boolean;
  category: string;
  size: string;
}

type Category = "Food" | "Drink" | "Dessert";

export default function C_StateEffectPostPractice() {
  const [menu, setMenu] = useState<PostMenuRequestDto>({
    name: "",
    description: "",
    price: 0,
    isAvailable: true,
    category: "",
    size: "",
  });
  
  const [result, setResults] = useState<PostMenuRequestDto>();
  const { name, description, price, isAvailable, category, size } = menu;

  const handleCategory = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setMenu((prevMenu) => ({
      ...prevMenu,
      [name]: value,
    }));
  };

  const submitCategory = async () => {
    try {
      const response = await axios.post(`${DOMAIN}/${MENU_API}/`, {
        name: name,
        description: description,
        price: price,
        isAvailable: isAvailable,
        category: category,
        size: size,
      });
      const data = response.data.data;
      setResults(data);
    } catch (error) {
      console.error("Failed Create Menu: ", error);
    }
  };

  useEffect(() => {

  }, []);

  return (
    <div>
      <input
        type="text"
        name="name"
        placeholder="name"
        onChange={handleCategory}
      />
      <input
        type="text"
        name="description"
        placeholder="description"
        onChange={handleCategory}
      />
      <input
        type="number"
        name="price"
        placeholder="price"
        onChange={handleCategory}
      />
      <input
        type="checkbox"
        name="isAvaliable"
        placeholder="isAvailable"
        checked={isAvailable}
        onChange={handleCategory}
      />
      <input
        type="text"
        name="category"
        placeholder="category"
        onChange={handleCategory}
      />
      <input
        type="text"
        name="size"
        placeholder="size"
        onChange={handleCategory}
      />
      <button type="submit" onClick={submitCategory}>
        메뉴 저장
      </button>
      <div>
        <ul>{result?.name}</ul>
        <ul>{result?.description}</ul>
        <ul>{result?.price}</ul>
        <ul>{result?.isAvailable}</ul>
        <ul>{result?.category}</ul>
        <ul>{result?.size}</ul>
      </div>
    </div>
  );
}
