import React, { useState } from "react";
import { downloadDLL } from "../services/api";
import "./DLLInput.css";
const DLLInput = () => {
  const [dllName, setDllName] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [message, setMessage] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!dllName.trim()) { setMessage("Please enter a DLL file name"); return; }
    setIsLoading(true); setMessage("");
    try {
      const res = await downloadDLL(dllName);
      setMessage(res.success ? `${dllName} downloaded successfully!` : (res.message || "Download failed"));
      if (res.success) setDllName("");
    } catch (err) { setMessage("Error: " + err.message); }
    finally { setIsLoading(false); }
  };
  return (
    <div className="dll-input-container">
      <div className="header"><h2>Respawn 🎮</h2><p>Download missing DLL files for gaming</p></div>
      <form onSubmit={handleSubmit} className="dll-form">
        <div className="input-group">
          <label htmlFor="dllName">Enter DLL file name:</label>
          <input id="dllName" value={dllName} onChange={(e) => setDllName(e.target.value)} placeholder="e.g., d3dx9_43.dll" disabled={isLoading} />
        </div>
        <button type="submit" disabled={isLoading || !dllName.trim()}>{isLoading ? "Downloading..." : "Download DLL 📥"}</button>
      </form>
      {message && (<div className={`message ${message.includes("Error") ? "error" : "success"}`}>{message}</div>)}
      <div className="info"><p>✨ Safe and reliable DLL downloads</p><p>⚡ Powered by Respawn backend</p></div>
    </div>
  );
};
export default DLLInput;
