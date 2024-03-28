import React from "react";
import Image from "next/image";
import fs from "fs";
import path from "path";

const CharacterImage = () => {
  // 이미지 파일 목록을 가져오기
  const imageFiles = fs.readdirSync(path.join(process.cwd(), "public/images/characters"));
  // 이미지 파일 중 랜덤으로 선택
  const randomImage = imageFiles[Math.floor(Math.random() * imageFiles.length)];

  return (
    <Image
      src={`/images/characters/${randomImage}`}
      width={600}
      height={0}
      sizes="100vh"
      alt="temp"
      className="object-contain"
    />
  );
};

export default CharacterImage;

