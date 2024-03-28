export const SkeletonListItem = () => {
  return (
    <li className="m-0 w-full h-[40px] p-[8px] flex items-center">
      <div className="w-[18px] h-[22px] bg-primary-bg-color rounded-sm" />
      <div className="w-[90%] h-[22px] ml-[8px] bg-primary-bg-color rounded-sm" />
    </li>
  );
};

export const SkeletonList = () => {
  return (
    <ul className="m-0 p-0">
      <SkeletonListItem />
      <SkeletonListItem />
      <SkeletonListItem />
      <SkeletonListItem />
      <SkeletonListItem />
    </ul>
  );
};

export const SkeletonTitle = () => {
  return (
    <div className="w-full h-[36px] border-b-[1px] border-slate-400 flex items-center font-bold px-[8px]">
      <div className="w-[120px] h-[20px] ml-[4px] bg-primary-bg-color rounded-sm" />
    </div>
  );
};

export const SkeletonFamousCharacter = () => {
  return (
    <div className="m-0 p-0 w-[360px] h-[236px] mx-[16px] bg-secondary-bg-color rounded-[4px] shimmer">
      <SkeletonTitle />
      <SkeletonList />
    </div>
  );
};

