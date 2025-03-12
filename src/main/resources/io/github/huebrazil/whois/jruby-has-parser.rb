require 'rubygems'
require 'whois-parser'
require 'java'

def hasParser(name)
  require "whois/parsers/#{name}"
  return true
rescue LoadError
  return false
end

return hasParser(host)

