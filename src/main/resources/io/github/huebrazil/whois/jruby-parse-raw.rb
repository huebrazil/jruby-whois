require 'rubygems'
require 'whois'
require 'whois-parser'
require 'java'
require 'io/github/huebrazil/whois/convert'

whois_data = [Whois::Record::Part.new(body: data, host: server)]
r = Whois::Record.new(server, whois_data)


convertResponseToJava(r)
