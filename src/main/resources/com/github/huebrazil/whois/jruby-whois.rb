require 'rubygems'
require 'whois'
require 'java'
require 'com/github/huebrazil/whois/convert'

# Set up a client
w = Whois::Client.new(timeout: timeout_param)

# Lookup the domain
r = w.lookup(domain)

convertResponseToJava(r)
