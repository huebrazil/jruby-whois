require 'rubygems'
require 'whois'
require 'java'

def hasParser(name)
  require "whois/record/parser/#{name}"
  return true
rescue LoadError
  return false
end

return hasParser(host)

