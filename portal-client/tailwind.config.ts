import type { Config } from "tailwindcss";
import plugin from "tailwindcss/plugin";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      keyframes: {
        spread: {
          "0%": { transform: "scaleX(0)" },
          "100%": { transform: "scaleX(1)" },
        },
      },
      animation: {
        "spread-horz": "spread 0.4s ease",
      },
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic": "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
      colors: {
        "primary-bg-color": "#1d2527",
        "secondary-bg-color": "#283338",
        "third-bg-color": "#465054",
        "main-button-color": "#237fb7",
        "main-button-focus-color": "#24a0ed",
        "legendary-color": "#fec763",
      },
    },
  },
  plugins: [
    plugin(function ({ addBase, addComponents, addUtilities, theme }) {
      addBase({});
      addComponents({
        ".shimmer": {
          position: "relative",
          width: "100%",
          height: "100%",
          overflow: "hidden",
        },
        ".shimmer:before": {
          content: '""',
          position: "absolute",
          inset: "0",
          transform: "translateX(-100%)",
          animation: "shimmer 2s infinite",
          backgroundImage: "linear-gradient(to right, transparent, rgba(255, 255, 255, 0.2), transparent)",
        },
        "@keyframes shimmer": {
          "0%": { transform: "translateX(-100%)" },
          "100%": { transform: "translateX(100%)" },
        },
      });
      addUtilities({});
    }),
  ],
};

export default config;

