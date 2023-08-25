import React from "react";
import logo from "../assets/logo.png";
import { BiWorld } from "react-icons/bi";
import { FiMenu } from "react-icons/fi";
import { BiUser } from "react-icons/bi";
import { BsSearch } from "react-icons/bs";
import { BsFillHouseFill } from "react-icons/bs";
const Navbar = () => {
  return (
    <div className="border b">
      <div className="flex justify-between items-center sm:mx-6 md:mx-10 lg:mx-12">
        {/* left */}
        <div className="h-20 flex">
          <img src={logo} className="object-cover -my-10" />
        </div>
        {/* middle */}
        <div className="hidden lg:flex justify-center items-center relative shadow-sm shadow-gray-400 border rounded-full">
          <input
            type="search"
            placeholder=""
            className="py-2.5 w-[20rem] rounded-full outline-0"
          />
          <div className="flex justify-between absolute w-full pr-16 pl-6 font-semibold text-gray-600">
            <button className=" w-full">Place</button>
            <button className="border-l border-x px-6">Time</button>
            <button className=" w-full text-gray-400 pl-2">Group Size</button>
          </div>
          <div className="bg-[#FFFD8C] p-2 rounded-full mr-2">
            <BsSearch className="font-bold w-full" />
          </div>
        </div>
        {/* right */}
        <div className="flex items-center pr-3 font-semibold text-gray-600">
          <div className=" ">
            <p className="text-[17px] font-bold">Rent house</p>
            {/* <BsFillHouseFill /> */}
          </div>
          <div className="flex items-center mx-8 gap-1">
            <BiWorld className="" />
            <div className="">EN</div>
          </div>
          <div className="flex items-center  border px-4 py-2 rounded-full gap-3 bg-[#FFFD8C] text-black font-bold shadow-lg shadow-gray-300 hover:bg-[#c4c37b] duration-100 ease-out">
            <button>Sign in</button>
            <BiUser className="text-[22px]" />
          </div>
          <div className="flex items-center  border px-4 py-2 mx-5 rounded-full gap-3 bg-[#FFFD8C] text-black font-bold shadow-lg shadow-gray-300 hover:bg-[#c4c37b] duration-100 ease-out">
            <button>Post</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
