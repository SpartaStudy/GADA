import React from "react";
import Image from "next/image";
import fs from "fs";
import path from "path";

const CharacterImage = () => {
  // 이미지 파일 목록을 가져오기
  const imageFiles = fs.readdirSync(path.join(process.cwd(), "public/images"));
  // 이미지 파일 중 랜덤으로 선택
  const randomImage = imageFiles[Math.floor(Math.random() * imageFiles.length)];
  console.log("this", randomImage);

  return (
    <Image
      src={`/images/${randomImage}`}
      width={400}
      height={0}
      sizes="50vh"
      alt="temp"
      className="object-contain aspect-square"
    />
  );
};

export default CharacterImage;

