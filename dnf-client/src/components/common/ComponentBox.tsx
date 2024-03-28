import React from "react";
import styled from "styled-components";

interface Props {
  children: React.ReactNode;
  flexDirection?: string;
  justifyContent?: string;
  alignItems?: string;
  flexWrap?: string;
}

interface StyledProps {
  $flexDirection?: string;
  $justifyContent?: string;
  $alignItems?: string;
  $flexWrap?: string;
}

const StyldBox = styled.div<StyledProps>`
  box-sizing: border-box;
  width: 100%;
  padding: 10px;
  border-radius: 10px;
  background-color: var(--secondary-bg-color);
  display: flex;
  ${(props) =>
    props.$flexDirection ? `flex-direction: ${props.$flexDirection};` : ""}
  ${(props) =>
    `justify-content: ${
      props.$justifyContent ? props.$justifyContent : "flex-start"
    };`}
  ${(props) =>
    `align-items: ${props.$alignItems ? props.$alignItems : "flex-start"};`}
  ${(props) => `flex-wrap: ${props.$flexWrap ? props.$flexWrap : "nowrap"};`}
  gap: 10px;
`;

const ComponentBox: React.FC<Props> = ({
  children,
  flexDirection,
  justifyContent,
  alignItems,
  flexWrap,
}) => {
  return (
    <StyldBox
      $flexDirection={flexDirection}
      $justifyContent={justifyContent}
      $alignItems={alignItems}
      $flexWrap={flexWrap}
    >
      {children}
    </StyldBox>
  );
};

export default ComponentBox;