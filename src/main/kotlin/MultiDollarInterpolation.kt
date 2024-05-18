import org.intellij.lang.annotations.Language

// you can use $ inside the string
fun receipt(name: String, amount: Double) =
    $$"$$name costs $$$amount"

// no need to use ${'$'}, it helps with language injections
@Language("json") val schema = $$"""
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "https://example.com/product.schema.json",
  "title": "Product",
  "description": "A product in the catalog",
  "type": "object"
}
"""
