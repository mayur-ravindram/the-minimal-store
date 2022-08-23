import React from "react";
import { Link } from "react-router-dom";

import imgPath from "../assets/404-panda.png";
const ErrorPage = () => {
  return (
    <div className="">
      <Link to={"/"}>
        <div className="m-2 p-2 bg-blue-400 w-20 rounded-md text-center shadow-md text-gray-200">
          Back
        </div>
      </Link>
      <div className="mt-4 flex justify-center align-middle">
        <img
          src={imgPath}
          alt="error image"
          width={800}
          className="aspect-auto"
        />
      </div>
    </div>
  );
};

export default ErrorPage;
