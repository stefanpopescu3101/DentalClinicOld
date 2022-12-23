import React from 'react'
import NewsItem from "./NewsItem";
function NewsList(props) {
    return (
        <ul>
            {props.news.map((news) => (
                <>
                    <br />
                    <NewsItem key={news.id} news={news}></NewsItem>
                    <br />
                </>
            ))}
        </ul>
    );
}

export default NewsList;
