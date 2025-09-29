# RemoveBOM.ps1
# This script removes BOM from all Java files in the specified folder (and subfolders)

# Change this path to your backend Java source folder
$javaFolder = "D:\Extension\backend\src\main\java"

# Get all Java files recursively
Get-ChildItem -Path $javaFolder -Recurse -Filter *.java | ForEach-Object {
    try {
        # Read file as a single string (-Raw)
        $content = Get-Content $_.FullName -Raw

        # Rewrite the file in UTF8 without BOM
        Set-Content -Encoding UTF8 $_.FullName $content

        Write-Host "Cleaned BOM:" $_.FullName
    } catch {
        Write-Warning "Failed to clean BOM for file:" $_.FullName
    }
}

Write-Host "All Java files cleaned!"
