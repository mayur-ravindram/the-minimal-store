import React from "react";

import imgPath from '../assets/404-panda.png'
const ErrorPage = () => {
    return (
        <div className="mx-auto p-3 shadow-lg">
            <div className="m-2 flex flex-col justify-around">
                <div>
                    <img src={imgPath} alt=""
                        className="rounded-t-lg shadow-" />
                </div>
                <h2 className="text-lg text-pink-500">we are currently facing problems 😔</h2>
            </div>
        </div>
    )
}

export default ErrorPage;