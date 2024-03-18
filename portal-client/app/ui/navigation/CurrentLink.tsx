import Image from "next/image";
import React from "react";

interface Props {
  icon: string;
  alt: string;
}

const CurrentLink = ({ icon, alt }: Props) => {
  console.log(icon);
  return (
    <div className="w-full h-[64px] border-solid border-b-2 border-slate-400 flex justify-center">
      <Image src={`/images/${icon}`} alt={alt} width={40} height={40} className="object-contain" />
    </div>
  );
};

export default CurrentLink;

