import React from "react";
import { BsSearch } from "react-icons/bs";
const Filters = () => {
  return (
    <div className="sm:mx-6 md:mx-10 lg:mx-12 pt-2">
      {/* left */}
      <div className="flex justify-between absolute gap-2 border rounded-full">
        <button className=" text-gray-600 font-bold  px-3 py-2 rounded-full">
          Sell
        </button>
        <button className=" text-gray-600 font-bold px-3 py-2 bg-[#FFFD8C] rounded-full hover:bg-[#a8a779]">
          Rent
        </button>
      </div>
      {/* middle */}
      {/* right */}
    </div>
  );
};

export default Filters;
