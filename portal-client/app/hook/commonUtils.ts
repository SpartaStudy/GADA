export const convertCombatPower = (combatPower: string | number = "") => {
  if (!combatPower) return "0";
  const power = +combatPower;
  const [TEN_MILLION, TEN_THOUSAND] = [100000000, 10000];
  const overTenMillion = Math.floor(power / TEN_MILLION);
  const overThousand = Math.floor((power - overTenMillion * TEN_MILLION) / TEN_THOUSAND);
  const underThousand = power - overTenMillion * TEN_MILLION - overThousand * TEN_THOUSAND;

  if (overThousand === 0) return `${underThousand}`;
  if (overTenMillion === 0) return `${overThousand}만 ${underThousand}`;
  return `${overTenMillion}억 ${overThousand}만 ${underThousand}`;
};
