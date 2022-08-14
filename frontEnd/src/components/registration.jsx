import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Header from "./header";

const Registration = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  let navigate = useNavigate();

  const register = (e) => {
    e.preventDefault();
    // axios({
    //   method: "post",
    //   url: "http://localhost:8081/api/security/register",
    //   data: {
    //     userName: email,
    //     password: password,
    //   },
    // })
    //   .catch((err) => {
    //     console.log(err);
    //     alert(err.response.data);
    //   })
    //   .then((res) => {
    //     if (res && res.statusText === "Created") {
    //       console.log(res);
    //       navigate("/");
    //     }
    //   });
    navigate("/")
  };

  return (
    <div className="h-screen  bg-slate-300">
      <Header />
      <div className=" flex items-center justify-center">
        <div className="w-1/3 p-4 mt-20 max-w-sm h-full bg-white rounded-lg border border-gray-200 shadow-md sm:p-6 lg:p-8">
          <form className="space-y-6">
            <h5 className="text-xl font-medium text-gray-900 ">Register</h5>
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
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="name@company.com"
                required=""
              />
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
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="••••••••"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 "
                required=""
              />
            </div>
            <div>
              <label
                htmlFor="confirm_password"
                className="block mb-2 text-sm font-medium text-gray-900"
              >
                Your password
              </label>
              <input
                type="password"
                name="confirm_password"
                id="confirm_password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="confirm password"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 "
                required=""
              />
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
                  I Agree
                </label>
              </div>
            </div>
            <div className="flex text-sm font-medium text-gray-500 ">
              <button
                type="submit"
                className="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center "
                onClick={register}
              >
                Register your account
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Registration;
