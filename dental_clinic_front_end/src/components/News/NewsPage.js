import { useState, useEffect } from "react";
import React from 'react'
import AuthService from "../Services/AuthService";
import NewsService from "../Services/NewsService";
import NewsList from "./NewsList";
import Slider from "../Slider/Slider";

function NewsPage() {
    const [news, setNews] = useState([]);

    useEffect(() => {
        NewsService.getNews().then((response) => {
            console.log(response.data);
            setNews(response.data);
        });
    }, []);

    return (
            <div>
                {AuthService.getCurrentUser() === null && (
                    <>
                        <Slider />
                        <br />
                        <div className="container">
                            <h1>News</h1>
                            <br />
                            <NewsList news={news} />
                        </div>
                    </>
                )}
            </div>
        );

}

export default NewsPage;
