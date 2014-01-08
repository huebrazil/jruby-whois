require 'rubygems'
require 'Whois'
require 'java'
import 'uk.bl.wa.whois.WhoisResult'

# Set up a client
w = Whois::Client.new

# Lookup the domain
r = w.lookup(domain)


# Test the country
isUK = false
if r.parser.registrant_contacts[0] != nil

  if r.parser.registrant_contacts[0].country == "United Kingdom"
    isUK = true
  end
  
  if r.parser.registrant_contacts[0].country_code == "UK"
    isUK = true
  end
end

WhoisResult.new(isUK,r.to_s)
        
 