const API_BASE_URL = import.meta.env.VITE_API_URL || "http://localhost:8080";
export const downloadDLL = async (dllName) => {
  try {
    const response = await fetch(`${API_BASE_URL}/api/dll/download`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ dllName: dllName.trim() })
    });
    if (!response.ok) {
      let err = "Failed to download DLL";
      try { const data = await response.json(); err = data.message || err; } catch {}
      throw new Error(err);
    }
    const blob = await response.blob();
    const url = window.URL.createObjectURL(blob);
    if (typeof chrome !== "undefined" && chrome.downloads) {
      chrome.downloads.download({ url, filename: dllName });
    } else {
      const link = document.createElement("a");
      link.href = url; link.download = dllName; document.body.appendChild(link); link.click(); document.body.removeChild(link);
    }
    window.URL.revokeObjectURL(url);
    return { success: true };
  } catch (error) { return { success: false, message: error.message }; }
};
export const searchDLL = async (query) => {
  const res = await fetch(`${API_BASE_URL}/api/dll/search?q=${encodeURIComponent(query)}`);
  if (!res.ok) throw new Error("Search failed");
  return res.json();
};
