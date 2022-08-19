import { useEffect, useState } from "react";
import "../index.css";
import Header from "./header";
import img from "../assets/samsung-galaxy-s22.png";
import AddProduct from "./AddProduct";

const Home = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [name, setName] = useState("");
  const [category, setCategory] = useState("");
  const [price, setPrice] = useState(0.0);
  const [color, setColor] = useState("");

  useEffect(() => {
    fetch(`http://127.0.0.1:8081/api/mongo/list`)
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            `This is an HTTP error: The status is ${response.status}`
          );
        }
        return response.json();
      })
      .then((actualData) => setData(actualData))
      .catch((err) => {
        console.log(err.message);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  return (
    <>
      <Header />

      <div className="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
        {loading && <div>A moment please...</div>}
        {error && (
          <div>{`There is a problem fetching the post data - ${error}`}</div>
        )}

        <h1 className="text-3xl my-10 uppercase font-semibold p-2">
          Available products
        </h1>
        <div className="grid grid-cols-1 gap-y-10 sm:grid-cols-2 gap-x-6 lg:grid-cols-3 xl:grid-cols-4 xl:gap-x-8">
          {data &&
            data.map((product) => (
              <a key={product.id} href="#" className="group shadow-lg">
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
