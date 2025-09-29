# RemoveAllBOM.ps1
# This script forcefully removes BOM from all Java files in the backend folder

$javaFolder = "D:\Extension\backend\src\main\java"

# Get all Java files recursively
Get-ChildItem -Path $javaFolder -Recurse -Filter *.java | ForEach-Object {
    $file = $_.FullName
    $maxRetries = 5
    $retry = 0
    $success = $false

    while (-not $success -and $retry -lt $maxRetries) {
        try {
            # Read file content
            $content = [System.IO.File]::ReadAllText($file)

            # Remove BOM if present
            if ($content.Length -gt 0 -and $content[0] -eq [char]0xFEFF) {
                $content = $content.Substring(1)
                [System.IO.File]::WriteAllText($file, $content, [System.Text.Encoding]::UTF8)
                Write-Host "Removed BOM:" $file
            } else {
                Write-Host "No BOM found:" $file
            }
            $success = $true
        } catch {
            $retry++
            Write-Warning "Failed to write $file. Retry $retry of $maxRetries."
            Start-Sleep -Seconds 1
        }
    }

    if (-not $success) {
        Write-Error "Could not remove BOM from $file after $maxRetries retries."
    }
}

Write-Host "All Java files processed!"
