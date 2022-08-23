import React, { useState } from "react";
import Header from "./header";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import authService from "../services/authService";
import ErrorPage from "./ErrorPage";
import { useForm } from "react-hook-form";

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loginSuccess, setLoginSuccess] = useState(false);
  let navigate = useNavigate();


  // validation stuff
  const { register, handleSubmit, formState: { errors } } = useForm();

  // Post request to login for USER AUTHENTICATION
  const login = (data) => {
    console.log(data.email,data.password);
    authService
      .login(data.email, data.password)
      .then((data) => {
        if (data.token) {
          navigate("/home");
        } else {
          setLoginSuccess(false);
        }
    })
    .catch((err) => {
        console.log(err);
        navigate("/error");
      });
  };

  // Post request to register for USER REGISTRATION
  const signUp = () => {
    navigate("/register");
  };

  const onSubmit = (e) => {
    setEmail(e.email);
    setPassword(e.password);
    console.log(e, email,password);
    login();
  };

  return (
    <div className="h-screen  bg-slate-300">
      <Header />

      <div className=" flex items-center justify-center">
        <div className="w-1/3 p-4 mt-20 max-w-sm h-full bg-white rounded-lg border border-gray-200 shadow-md sm:p-6 lg:p-8">
          <form className="space-y-6" onSubmit={handleSubmit(login)}>
            <h5 className="text-xl font-medium text-gray-900 ">Log in</h5>
            <div>
              <label
                htmlFor="email"
                className="block mb-2 text-sm font-medium text-gray-900"
              >
                Your email
              </label>
              <input
                type="email"
                name="email"
                id="email"
                // value={email}
                // onChange={(e) => setEmail(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="name@company.com"
                required=""
                {...register("email", { required: true })}
                />
              {errors.email?.type === 'required' && "Email is required"}
            </div>
            <div>
              <label
                htmlFor="password"
                className="block mb-2 text-sm font-medium text-gray-900"
                >
                Your password
              </label>
              <input
                type="password"
                name="password"
                id="password"
                placeholder="••••••••"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 "
                required=""
                // value={password}
                // onChange={(e) => setPassword(e.target.value)}
                {...register("password", { required: true })}
                />
                {errors.password?.type === 'required' && "Password is required"}
            </div>
            <div className="flex items-start">
              <div className="flex items-start">
                <div className="flex items-center h-5">
                  <input
                    id="remember"
                    type="checkbox"
                    value=""
                    className="w-4 h-4 bg-gray-50 rounded border border-gray-300 focus:ring-3 focus:ring-blue-300 "
                    required=""
                  />
                </div>
                <label
                  htmlFor="remember"
                  className="ml-2 text-sm font-medium text-gray-900 "
                >
                  Remember me
                </label>
              </div>
            </div>
            <div className="flex text-sm font-medium text-gray-500 ">
              <div>
                Not registered?{" "}
                <a
                  onClick={signUp}
                  className="text-blue-700 hover:cursor-pointer "
                >
                  Create account
                </a>
              </div>
              <button
                type="submit"
                className="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center "
              >
                Login to your account
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
