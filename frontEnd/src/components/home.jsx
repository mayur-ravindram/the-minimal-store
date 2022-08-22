import { useEffect, useState } from "react";
import "../index.css";
import Header from "./header";
import img from "../assets/samsung-galaxy-s22.png";
import AddProduct from "./AddProduct";
import ErrorPage from "./ErrorPage";
import authService from "../services/authService";
import productService from "../services/productService";

const Home = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [name, setName] = useState("");
  const [category, setCategory] = useState("");
  const [price, setPrice] = useState(0.0);
  const [color, setColor] = useState("");

  useEffect(() => {
    productService
      .listProducts()
      .then((response) => {
        if (!response.ok) {
          setError(true);
        }
        return response.json();
        setData(response.data);
        setLoading(false);
      })
      .catch((err) => {
        setError(true);
        console.log(err.message);
      })
      .finally(() => {
        setLoading(false);
        console.log(err);
        setError(true);
      });
  }, []);

  return (
    <>
      <Header />

      <div className="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
        {loading && <div>A moment please...</div>}
        {error && (
          <ErrorPage />
        )}
        {!error && (
          <h1 className="text-3xl my-10 uppercase font-semibold p-2">
            available products
          </h1>
        )}
        <div className="grid grid-cols-1 gap-y-10 sm:grid-cols-2 gap-x-6 lg:grid-cols-3 xl:grid-cols-4 xl:gap-x-8">
          {data &&
            data.map((product) => (
              <a key={product._id} href="#" className="group shadow-lg">
                <div className="shadow-sm rounded-lg overflow-hidden aspect-square">
                  <img
                    src={product.imageSrc}
                    alt={product.imageAlt}
                    className="group-hover:opacity-75"
                  />
                </div>
                <div className="flex justify-between p-4 items-center">
                  <div>
                    <h3 className="mt-1 text-lg font-medium text-gray-900">
                      {product.name}
                    </h3>
                    <p className="mt-4 text-md font-bold text-gray-700">
                      {product.price}
                    </p>
                  </div>
                  <div className="bg-green-500 rounded-md w-12 h-12 flex items-center justify-center">
                    <span className="text-center text-sm">buy</span>
                  </div>
                </div>
              </a>
            ))}
        </div>
      </div>
    </>
  );
};

export default Home;

async function makeAuthenticateCall() {
  var options = {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },

    body: JSON.stringify({
      username: "mayur",
      password: "password",
    }),
  };
  await fetch("http://localhost:8081/api/authenticate", options)
    .then((response) => {
      response.json();
    })
    .catch((err) => {
      console.log(err);
    });
}
