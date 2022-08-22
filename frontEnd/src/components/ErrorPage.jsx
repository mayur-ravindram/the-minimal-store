import React from "react";

import imgPath from "../assets/404-panda.png";
const ErrorPage = () => {
  return (
    <div className="p-4 shadow-lg">
      <div className="flex flex-col justify-center align-middle">
        <img
          src={imgPath}
          alt="error image"
          className="rounded-t-lg aspect-auto"
        />
        <h2 className="text-lg text-pink-500">
          we are currently facing problems 😔
        </h2>
      </div>
    </div>
  );
};

export default ErrorPage;
